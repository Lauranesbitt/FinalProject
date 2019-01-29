// code sourced from https://www.dfrobot.com/blog-767.html

#define WLAN_SSID       "UPC3626949"
#define WLAN_PASS       "YEUYQETQ"
#define WLAN_SECURITY   WPA-PSK
int heartPin = A1;   //for analog input
//remember you put the switch towards 'A' not 'D' for analog input

void setup()  {

 }

void loop()  {
  int heartValue = analogRead(heartPin);    //reading the analog value
  Serial.println(heartValue);   //printing the value tot the serial plotter
  delay(5);
  }

 #define thing_name  "laura-nesbitt"
