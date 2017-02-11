package au.edu.unsw.soacourse.validater;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2016-05-29T19:51:00.162+10:00
 * Generated source version: 3.0.4
 * 
 */
@WebServiceClient(name = "DLValidationService", 
                  wsdlLocation = "file:/Users/air/Documents/workspace/DLValidation/src/main/resources/wsdl/DLValidation.wsdl",
                  targetNamespace = "http://soacourse.unsw.edu.au/Validater") 
public class DLValidationService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://soacourse.unsw.edu.au/Validater", "DLValidationService");
    public final static QName DLValidationSOAP = new QName("http://soacourse.unsw.edu.au/Validater", "DLValidationSOAP");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/air/Documents/workspace/DLValidation/src/main/resources/wsdl/DLValidation.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(DLValidationService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/Users/air/Documents/workspace/DLValidation/src/main/resources/wsdl/DLValidation.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public DLValidationService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public DLValidationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DLValidationService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public DLValidationService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public DLValidationService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public DLValidationService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns DLValidationPT
     */
    @WebEndpoint(name = "DLValidationSOAP")
    public DLValidationPT getDLValidationSOAP() {
        return super.getPort(DLValidationSOAP, DLValidationPT.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DLValidationPT
     */
    @WebEndpoint(name = "DLValidationSOAP")
    public DLValidationPT getDLValidationSOAP(WebServiceFeature... features) {
        return super.getPort(DLValidationSOAP, DLValidationPT.class, features);
    }

}