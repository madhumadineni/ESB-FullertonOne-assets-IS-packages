package FHGCommonServices;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.passman.PasswordManagerException;
import com.wm.app.b2b.server.globalvariables.GlobalVariablesException;
import com.wm.app.b2b.server.globalvariables.GlobalVariablesManager;
// --- <<IS-END-IMPORTS>> ---

public final class config

{
	// ---( internal utility methods )---

	final static config _instance = new config();

	static config _newInstance() { return new config(); }

	static config _cast(Object o) { return (config)o; }

	// ---( server methods )---




	public static final void getConfigValue (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getConfigValue)>> ---
		// @sigtype java 3.5
		// [i] field:0:required configKey
		// [o] field:0:required configValue
		// pipeline
		
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	configKey = IDataUtil.getString( pipelineCursor, "configKey" );
		pipelineCursor.destroy();
		String value=null;
		try {
			 value =GlobalVariablesManager.getInstance().getGlobalVariableValue(configKey).getValue();
		} catch (GlobalVariablesException | PasswordManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "configValue", value );
		pipelineCursor_1.destroy();
			
		// --- <<IS-END>> ---

                
	}
}

