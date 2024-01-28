int LED1 = 1;
int LED = 2;
void setup() {
  // put your setup code here, to run once:
pinMode(LED1, OUTPUT);
pinMode(LED, OUTPUT);
}
void loop() {
  // put your main code here, to run repeatedly:
    digitalWrite(LED, HIGH);
    delay(600);
    digitalWrite(LED1, LOW);
    delay(600);

  // put your main code here, to run repeatedly:
    digitalWrite(LED1, HIGH);
    delay(600);
    digitalWrite(LED, LOW);
    delay(600);


}

