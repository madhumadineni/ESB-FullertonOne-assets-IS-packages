package FHGUtilities;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.app.b2b.server.InvokeState;
// --- <<IS-END-IMPORTS>> ---

public final class services

{
	// ---( internal utility methods )---

	final static services _instance = new services();

	static services _newInstance() { return new services(); }

	static services _cast(Object o) { return (services)o; }

	// ---( server methods )---




	public static final void getCurrentContextID (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getCurrentContextID)>> ---
		// @sigtype java 3.5
		// [o] field:0:required contextID
		// [o] field:0:required parentID
		// [o] field:0:required rootID
		// pipeline
		String[] contextStack;  
		String contextID = "";   
		String parentID = "";   
		String rootID = "";   
		try{  
		contextStack = InvokeState.getCurrentState().getAuditRuntime().getContextStack();   
		if (contextStack.length >= 5){   
		rootID = contextStack[0];   
		parentID = contextStack[2];   
		contextID = contextStack[3];   
		}   
		else if (contextStack.length >= 2){   
		contextID = contextStack[0];   
		parentID = contextStack[1];   
		rootID = contextStack[contextStack.length - 1]; }   
		else if (contextStack.length == 1) {   
		contextID = contextStack[0];   
		}   
		}  
		catch(Exception ex){   
		ServiceException sx = new ServiceException(ex);  
		throw sx;   
		}  
		// pipeline  
		IDataCursor pipelineCursor_1 = pipeline.getCursor();  
		IDataUtil.put(pipelineCursor_1, "contextID", contextID);  
		IDataUtil.put(pipelineCursor_1, "parentID", parentID);  
		IDataUtil.put(pipelineCursor_1, "rootID", rootID);  
		pipelineCursor_1.destroy();  
		// --- <<IS-END>> ---

                
	}
}

