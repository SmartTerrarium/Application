# Application
app for android phones


INTRODUCTION
–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––

The SmartTerrarium Application corresponds to the senior design 
progect for a indoor plant care system that monitors the temperature,
light exposure, and moisture levels, and also has the ability to 
control these moisture levels. 

It has a main menu that serves as a go-between for the info pages for 
each plant in the terrarium (up to three), these are the pages that
display the information listed above. The code calls the information 
from a database that has been set up through Firebase.


REQUIREMENTS
–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––

I used AndroidStudio for the code, but anything that can run java 
should be able to compile my code. I used Firebase as the database 
that my app communicates with, and I used an emulator downloaded from
android studio to test and check my app on a device, but if you have an
android phone readily available, you can use that too.


INSTALLATION 
–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––

For the Android Studio setup, follow their instructions for installment
on their website (link below). You can also find helpful instructions 
and advice for creating your first app.
https://developer.android.com/studio/?gclid=Cj0KCQjwhZr1BRCLARIsALjRV
QOMH-z8xwGSMLirrKwQJPm248ATNcwpn8lO-YydPjiKIRaFXLr4_4waAh5MEALw_wcB&gc
lsrc=aw.ds

To incorporate Firebase into the app in Android Studio, follow the 
steps outlined in the website below. 
https://firebase.google.com/docs/android/setup


CONFIGURATION
–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––

This app doesn't have application settings to change, but it does have 
the main menu to get between each. The main menu is very simple, with 
only three buttons, one for each of the plant info pages. The info 
pages themselves have a bit more going on, however. 

The individual plant pages have the readings from the database for 
the displays, and also have two spots that both read and write to the
database.

The database must be set up before you can really test it properly. I 
set up a test database to work with until the sensors will be able to 
read the values into the correct locations. This test database was set
up in Firebase as a realtime database. There is a cloud option, but I 
think the realtime works better for this application.


USERS
–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––

Rosemary Pedregon (writer) - SmartTerraium design team member
Aubrey Ashton - SmartTerraium design team member
Joseph Shandera - SmartTerraium design team member
