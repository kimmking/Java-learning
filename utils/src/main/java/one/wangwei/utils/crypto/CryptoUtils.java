package one.wangwei.utils.crypto;


import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadKeyTemplates;

import java.security.GeneralSecurityException;

public class CryptoUtils {

    public static void main(String[] args) throws GeneralSecurityException {

        KeysetHandle keysetHandle = KeysetHandle.generateNew(AeadKeyTemplates.AES128_GCM);


    }
}
