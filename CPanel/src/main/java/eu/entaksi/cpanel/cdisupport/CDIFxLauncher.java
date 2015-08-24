package eu.entaksi.cpanel.cdisupport;

import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import javax.enterprise.util.AnnotationLiteral;

/**
 * Created by uzumaki on 24/08/15.
 */
public class CDIFxLauncher extends Application
{
        public static void main(String[] args)
        {
            String os = System.getProperty("os.name");
            if (os.toLowerCase().contains("linux"))
            {
                // TODO inserire il codice per identificare Fedora 64
                boolean fedora64 = true;

                if (fedora64)
                    System.setProperty("sun.security.smartcardio.library", "/usr/lib64/libpcsclite.so.1");
            }
            Application.launch(CDIFxLauncher.class, args);
        }

        @SuppressWarnings("serial")
        @Override
        public void start(final Stage primaryStage) throws Exception
        {
            CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();
            cdiContainer.boot();
            BeanProvider.getContextualReference(ApplicationParametersProvider.class, false).setParameters(getParameters());
            cdiContainer.getBeanManager().fireEvent(primaryStage, new AnnotationLiteral<StartupScene>()
            {
            });
        }
}
