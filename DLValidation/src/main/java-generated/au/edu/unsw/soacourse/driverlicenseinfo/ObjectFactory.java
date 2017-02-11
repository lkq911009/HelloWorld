
package au.edu.unsw.soacourse.driverlicenseinfo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the au.edu.unsw.soacourse.driverlicenseinfo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DriverLicenceMessage_QNAME = new QName("http://soacourse.unsw.edu.au/DriverLicenseInfo", "driverLicenceMessage");
    private final static QName _ValidMessage_QNAME = new QName("http://soacourse.unsw.edu.au/DriverLicenseInfo", "validMessage");
    private final static QName _ServiceFaultMessage_QNAME = new QName("http://soacourse.unsw.edu.au/DriverLicenseInfo", "serviceFaultMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: au.edu.unsw.soacourse.driverlicenseinfo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DlInputType }
     * 
     */
    public DlInputType createDlInputType() {
        return new DlInputType();
    }

    /**
     * Create an instance of {@link ValidateType }
     * 
     */
    public ValidateType createValidateType() {
        return new ValidateType();
    }

    /**
     * Create an instance of {@link ServiceFaultType }
     * 
     */
    public ServiceFaultType createServiceFaultType() {
        return new ServiceFaultType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DlInputType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soacourse.unsw.edu.au/DriverLicenseInfo", name = "driverLicenceMessage")
    public JAXBElement<DlInputType> createDriverLicenceMessage(DlInputType value) {
        return new JAXBElement<DlInputType>(_DriverLicenceMessage_QNAME, DlInputType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soacourse.unsw.edu.au/DriverLicenseInfo", name = "validMessage")
    public JAXBElement<ValidateType> createValidMessage(ValidateType value) {
        return new JAXBElement<ValidateType>(_ValidMessage_QNAME, ValidateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soacourse.unsw.edu.au/DriverLicenseInfo", name = "serviceFaultMessage")
    public JAXBElement<ServiceFaultType> createServiceFaultMessage(ServiceFaultType value) {
        return new JAXBElement<ServiceFaultType>(_ServiceFaultMessage_QNAME, ServiceFaultType.class, null, value);
    }

}
