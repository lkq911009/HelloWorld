
package dlValidate;

import javax.jws.WebService;

@WebService(endpointInterface = "dlValidate.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

