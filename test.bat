SET projectLocation=G:\FPT IVS\Selenium
CD %projectLocation%
SET classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG testng.xml
PAUSE