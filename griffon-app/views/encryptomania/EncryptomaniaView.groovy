package encryptomania

import griffon.core.artifact.GriffonView
import griffon.metadata.ArtifactProviderFor
import javax.swing.SwingConstants

@ArtifactProviderFor(GriffonView)
class EncryptomaniaView {
    FactoryBuilderSupport builder
    EncryptomaniaModel model

    void initUI() {
        builder.with {
            actions {
                action(encryptAction, enabled: bind { model.decrypted })
                action(decryptAction, enabled: bind { model.encrypted })

            }
            application(size: [320, 160], id: 'mainWindow',
                title: application.configuration['application.title'],
                pack: true, locationByPlatform: true,
                iconImage:   imageIcon('/griffon-icon-48x48.png').image,
                iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                             imageIcon('/griffon-icon-32x32.png').image,
                             imageIcon('/griffon-icon-16x16.png').image]) {

                panel(border: emptyBorder(6)){
                    gridLayout(rows: 2, cols: 4)
                    label(id: 'passwordLabel', text: 'Password')
                    textField(editable: true, text: bind ('password', source: model, mutual: true))
                    label(id: 'saltLabel', text: 'Salt')
                    textField(editable: true, text: bind ('salt', source: model, mutual: true))
                    textField(editable: true, text: bind ('decrypted',target: model, mutual: true))
                    button(id: 'encryptButton', encryptAction)
                    button(id: 'decryptButton', decryptAction)
                    textField(editable: true, text: bind ('encrypted',target: model, mutual: true))

                }
            }
        }
    }
}