package encryptomania

import griffon.core.injection.Module
import griffon.inject.DependsOn
import griffon.swing.SwingWindowDisplayHandler
import org.codehaus.griffon.runtime.core.injection.AbstractModule
import org.kordamp.jipsy.ServiceProviderFor

import static griffon.util.AnnotationUtils.named


@DependsOn('swing')
@ServiceProviderFor(Module)
class ApplicationModule extends AbstractModule {
    @Override
    protected void doConfigure() {

        bind(SwingWindowDisplayHandler)
                .withClassifier(named('defaultWindowDisplayHandler'))
                .to(CenteringWindowDisplayHandler)
                .asSingleton()
    }
}