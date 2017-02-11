package au.edu.unsw.soacourse.validater;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.jws.WebService;

import au.edu.unsw.soacourse.driverlicenseinfo.DlInputType;
import au.edu.unsw.soacourse.driverlicenseinfo.ObjectFactory;
import au.edu.unsw.soacourse.driverlicenseinfo.ValidateType;

@WebService(endpointInterface = "au.edu.unsw.soacourse.validater.DLValidationPT")
public class DLValidationImpl implements DLValidationPT {

	@Override
	public ValidateType driverValidate(DlInputType dlreq) {
		// TODO Auto-generated method stub
		ObjectFactory factory = new ObjectFactory();
		ValidateType res = factory.createValidateType();
		res.setValid("No");
		String fullName = dlreq.getFullName();
		String licenceNum = dlreq.getLicenseNum();
		System.out.println(fullName);
		System.out.println(licenceNum);
		//String line=System.getProperty("java.class.path");
		String path=this.getClass().getResource("LicenceRecord.xml").getPath();

		Boolean validFlag=false;
		InputStream input=null;
		try {
			File file=new 
					File(path);
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LicenceParser dom = new LicenceParser();
		List<DriverLicenseBean> record = null;
		if (input != null) {
			try {
				record = dom.getRecords(input);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		
		 if (record != null) {
			 for (int i = 0; i < record.size(); i++) {
				 DriverLicenseBean temp = record.get(i);
				 if(temp.getFullName().equals(fullName)
						 &&temp.getLicenceNum().equals(licenceNum))
				 {
					 validFlag=true;
				 }
			 }

		 }
		 if(validFlag)
			 res.setValid("YES");
		return res;
	}
}
