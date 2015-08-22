package tutorial;

import net.cassite.style.Supportters.StyleRuntimeException;
import net.cassite.style.Style;

/**
 * Enhanced Throwable<br/>
 * 
 * @author wkgcass
 *
 */
public class EnhancedThrowable extends Style {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			System.out.println("Throwable support============");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e1) {
				$(e1).throwIn(RuntimeException.class);
				$(e1).throwNotIn(Error.class);
			}
		} catch (StyleRuntimeException sre) {
			sre.origin(); // get original throwable
			sre.getCause(); // invokes src.origin().getCause(), in case of
							// InvocationTargetException, invokes
							// .getTargetException();
		}
	}

}
