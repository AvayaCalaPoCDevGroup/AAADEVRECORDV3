package AAADEVRECORDV3.Http.MediaListeners;

import java.util.UUID;

import service.AAADEVRECORDV3.MyEmailSender;

import com.avaya.collaboration.call.Call;
import com.avaya.collaboration.call.media.MediaListenerAbstract;
import com.avaya.collaboration.call.media.PlayOperationCause;
import com.avaya.collaboration.util.logger.Logger;

public class MediaListenerPlayHelsinky extends MediaListenerAbstract{
	private final Logger logger = Logger.getLogger(getClass());
	private final Call call;
    /*
     * Constructor
     */
    public MediaListenerPlayHelsinky(final Call call)
    {
        this.call = call;
    }
    
	@Override
	public void playCompleted(UUID requestId, PlayOperationCause cause) {
    	if(cause == PlayOperationCause.COMPLETE){
    		logger.info("MediaListenerPlayError PlayOperationCause.COMPLETE");
    	}
    	if(cause == PlayOperationCause.FAILED){
    		logger.info("MediaListenerPlayError PlayOperationCause.FAILED");
    		new MyEmailSender().sendErrorByEmail("MediaListenerPlayError PlayOperationCause.FAILED", call);
    	}
    	if(cause == PlayOperationCause.INTERRUPTED){
    		logger.info("MediaListenerPlayError PlayOperationCause.INTERRUPTED");
    	}
    	if(cause == PlayOperationCause.STOPPED){
    		logger.info("MediaListenerPlayError PlayOperationCause.STOPPED");
    	}
	}
    
    
    
    
}
