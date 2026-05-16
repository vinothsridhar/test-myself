package in.sri.test.ds;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;

public class NioServer {

    public static void main(String args[]) throws IOException {
        
        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("Server started on port 8080");

        ByteBuffer buffer = ByteBuffer.allocate(256);

        while (true) {
            selector.select();

            for (SelectionKey key : selector.selectedKeys()) {
                if (key.isAcceptable()) {
                    // Handle new client connection
                    SocketChannel clientChannel = serverSocketChannel.accept();
                    clientChannel.configureBlocking(false);
                    clientChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("New client connected: " + clientChannel.getRemoteAddress() + " at " + System.nanoTime());
                } else if (key.isReadable()) {
                    // Handle client data
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    clientChannel.configureBlocking(false);
                    handleClientData(clientChannel, buffer);
                }
            }

            selector.selectedKeys().clear();
        }
    }

    private static void handleClientData(SocketChannel clientChannel, ByteBuffer buffer) throws IOException {
        buffer.clear();
        int bytesRead = clientChannel.read(buffer);
        if (bytesRead == -1) {
            clientChannel.close();
            System.out.println("Client disconnected");
        } else {
            buffer.flip();
            byte[] data = new byte[buffer.limit()];
            buffer.get(data);
            String received = new String(data);
            Map<String, Object> parsedRequest = requestParser(received);
            router(parsedRequest, clientChannel);
            System.out.println("Client data processed: " + clientChannel.getRemoteAddress() + " at " + System.nanoTime());
            clientChannel.close();
            buffer.clear();
        }
    }

    private static void router(Map<String, Object> requestParts, SocketChannel clientChannel) throws IOException {
        String path = (String) requestParts.get("path");
        if ("/hello".equals(path)) {
            handleHello(requestParts, clientChannel);
        } else {
            System.out.println("Unknown route: " + path);
        }
    }

    private static void handleHello(Map<String, Object> requestParts, SocketChannel clientChannel) {
        String response = "HTTP/1.1 200 OK\r\nContent-Type: application/json\r\n\r\n";
        Map<String, String> queryParams = (Map<String, String>) requestParts.get("queryParams");
        String name = queryParams.getOrDefault("name", "World");
        response += "{\"message\": \"Hello, " + name + "}";
        ByteBuffer responseBuffer = ByteBuffer.wrap(response.getBytes());
        try {
            clientChannel.write(responseBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            responseBuffer.clear();
        }
    }

    private static Map<String, Object> requestParser(String request) throws IOException {
        String[] lines = request.split("\r\n");
        String requestLine = lines[0];
        String[] requestParts = requestLine.split(" ");
        String method = requestParts[0];
        String path = requestParts[1];
        Map<String, String> headers = new HashMap<>();
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            if (line.isEmpty()) {
                break;
            }
            String[] headerParts = line.split(": ");
            if (headerParts.length == 2) {
                headers.put(headerParts[0], headerParts[1]);
            }
        }
        Map<String, String> queryParams = new HashMap<>();
        if (path.contains("?")) {
            String[] pathParts = path.split("\\?");
            path = pathParts[0];
            String queryString = pathParts[1];
            String[] queryPairs = queryString.split("&");
            for (String pair : queryPairs) {
                String[] keyValue = pair.split("=");
                if (keyValue.length == 2) {
                    queryParams.put(keyValue[0], keyValue[1]);
                }
            }
        }
        Map<String, Object> requestPartsMap = new HashMap<>();
        requestPartsMap.put("method", method);
        requestPartsMap.put("path", path.split("\\?")[0]);
        requestPartsMap.put("headers", headers);
        requestPartsMap.put("queryParams", queryParams);
        return requestPartsMap;
    }

}
