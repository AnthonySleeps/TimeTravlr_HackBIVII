int LED = 2;
int LED1 = 1;

void setup() {
  // put your setup code here, to run once:
pinMode(LED, OUTPUT);


volatile long last = 0;
volatile bool turnOff = false;
volatile long offAt = 0;


    if( (millis() - last ) > 20 ) //if at least 20 ms has passed since last press, this is not a dup
    {
        last = millis(); //note the time, for ignoring duplicate presses
        turnOff = true;
        offAt = millis() + 100000; //save a variable of now + 5 seconds
        digitalWrite(LED, HIGH); //turn on
    }


    if( (millis() - last ) > 200000 ) //if at least 20 ms has passed since last press, this is not a dup
    {
        last = millis(); //note the time, for ignoring duplicate presses
        turnOff = true;
        offAt = millis() + 100000; //save a variable of now + 5 seconds
        digitalWrite(LED1, HIGH); //turn on
    }


}
void loop() {
  // put your main code here, to run repeatedly:
  //if ("1"); 

    
 
    {
       digitalWrite(LED, LOW); //turn off led
    } 
    digitalWrite(LED1, HIGH);
     
     
      

  //if ("0");

    digitalWrite(LED, HIGH);
     
  
       
}
