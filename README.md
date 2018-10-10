# WeatherUndergroundWeb_SmartThings
Smartapp and device to automate things based on WeatherUnderground services provided through SmartThings API

<li>Import in your IDE the Smartapp and devicehandlers and publish the 2 for yourselves</li>
<li>In the SmartApp menu of the Automation section in the mobile app, add Weather Underground Web Smartapp
<li> Setup the threshold and alerts you want to monitor</li>
<li> Select the switches you want to turn on or off upon the alert trigger</li>
<li> Enjoy localized weather alerts and automation!</li>

<form target="paypal" action="https://www.paypal.com/cgi-bin/webscr" method="post" >
<input type="hidden" name="cmd" value="_s-xclick">
<table>
<tr><td><input type="hidden" name="on0" value="Tip">Tip</td></tr><tr><td><select name="os0">
	<option value="Tip 1">Tip 1 $1.00 USD</option>
	<option value="Tip 2">Tip 2 $5.00 USD</option>
	<option value="Tip 3">Tip 3 $10.00 USD</option>
</select> </td></tr>
</table>
<input type="hidden" name="currency_code" value="USD">
<input type="hidden" name="encrypted" value="-----BEGIN PKCS7-----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-----END PKCS7-----
">
<input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_cart_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
<img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
</form>
