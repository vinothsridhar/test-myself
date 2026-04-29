### JWT creation Flow
~~~
1. Create Header JSON
        ↓
2. Base64URL Encode Header

3. Create Payload JSON
        ↓
4. Base64URL Encode Payload

        ↓
5. Concatenate →  header_b64 + "." + payload_b64

        ↓
6. Sign this string using HMAC-SHA256 + Secret Key

        ↓
7. Base64URL Encode the resulting signature

        ↓
8. Final JWT = header.payload.signature
~~~

### JWT Verification Flow
~~~
1. Receive JWT from Client
        ↓
2. Split into Header . Payload . Signature
        ↓
3. Decode Header → Check Algorithm (reject 'none')
        ↓
4. Re-create message: base64(header) + "." + base64(payload)
        ↓
5. Verify Signature using Secret Key / Public Key
        ↓
        ├── No  → Reject (Tampered Token)
        └── Yes → Continue
                    ↓
6. Decode Payload
        ↓
7. Validate Claims (exp, iat, iss, aud, etc.)
        ↓
        ├── Invalid → Reject
        └── Valid   → Accept Token
~~~