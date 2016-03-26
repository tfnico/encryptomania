package encryptomania

import griffon.core.artifact.GriffonController
import griffon.metadata.ArtifactProviderFor
import org.springframework.security.crypto.encrypt.Encryptors


@ArtifactProviderFor(GriffonController)
class EncryptomaniaController {

    EncryptomaniaModel model

    void encrypt(){
        model.encrypted = Encryptors.text(model.password, model.salt).encrypt(model.decrypted)
    }

    void decrypt(){
        model.decrypted = Encryptors.text(model.password, model.salt).decrypt(model.encrypted)
    }
}