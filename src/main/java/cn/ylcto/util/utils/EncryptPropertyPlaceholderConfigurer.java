package cn.ylcto.util.utils;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
//属性需与配置文件的key保持一致
	private String[] encryptPropNames = {"db.user","db.password"};
	
	@Override
	protected String convertProperty(String propertyName,String propertyValue){
		//如果在加密属性名单中发现该属性  
        if (isEncryptProp(propertyName)) {
            String decryptValue = DESUtil.getDecryptString(propertyValue);
            System.out.println(decryptValue);
            return decryptValue;
        } else {
            return propertyValue;
        }

    }

    private boolean isEncryptProp(String propertyName) {
        for (String encryptName : encryptPropNames) {
            if (encryptName.equals(propertyName)) {
                return true;
            }
        }
        return false;
    }

}
