package setup;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ExpectedConditionsCustom {

	public static ExpectedCondition<Boolean> stalenessOf(final WebElement element) {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver ignored) {
				try {
					// Chamando metodo forcado para verificar se o elemento esta staleness ou nosuch
					element.isEnabled();
					return false;
				} catch (StaleElementReferenceException | NoSuchElementException expected) {
					return true;
				}
			}

			@Override
			public String toString() {
				return String.format("elemento (%s) se tornar stale ou nosuch", element);
			}
		};
	}

}
