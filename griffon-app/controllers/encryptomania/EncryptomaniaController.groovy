package encryptomania

import griffon.core.GriffonApplication
import griffon.core.artifact.GriffonController
import griffon.core.event.EventRouter
import griffon.metadata.ArtifactProviderFor
import org.springframework.security.crypto.encrypt.Encryptors

import javax.inject.Inject
import javax.swing.JOptionPane
import java.security.InvalidKeyException


@ArtifactProviderFor(GriffonController)
class EncryptomaniaController {

    @Inject
    EventRouter eventRouter

    @Inject
    GriffonApplication app

    EncryptomaniaModel model

    void encrypt() {
        //TODO: Use the EncryptorBuilder if it ever gets merged.
        model.encrypted = model.queryable ?
                convert { Encryptors.queryableText(model.password, model.salt).encrypt(model.decrypted) } :
                convert { Encryptors.text(model.password, model.salt).encrypt(model.decrypted) }
    }

    void decrypt() {
        model.decrypted = model.queryable ?
                convert { Encryptors.queryableText(model.password, model.salt).decrypt(model.encrypted) } :
                convert { Encryptors.text(model.password, model.salt).decrypt(model.encrypted) }

    }

    private String convert(Closure encryptionClosure) {
        try {
            String result = encryptionClosure.call()
            return result
        } catch (IllegalArgumentException e) {
            String errorMessage
            if (e.getCause() instanceof InvalidKeyException){
                errorMessage = "InvalidKeyException usually means you have to install the JCE in your JRE, " +
                        "or use a max keyLength of 128 (which we don't support yet): " + e.getMessage()
            } else {
                errorMessage = e.getMessage()
            }
            showErrorMessage(errorMessage)
            throw e
        }
    }

    private showErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(
                app.windowManager.findWindow('mainWindow'),
                'Exception: ' + errorMessage,
                'An error occurred', JOptionPane.ERROR_MESSAGE)
    }
}