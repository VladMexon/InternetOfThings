from flask import Flask
from flask_restful import Api, Resource
import OPi.GPIO as GPIO

GPIO.setboard(GPIO.PC2)
GPIO.setmode(GPIO.BOARD)
GPIO.setup(12, GPIO.OUT)

def LightOn(): #включить свет
    GPIO.putput(12, True)
    print("light turned on")

def LightOff(): #выключить свет
    GPIO.putput(12, False)
    print("light turned off")


class LightUpdate(Resource):
    def get(self, id=0):
        if (id == 1):
            LightOn()
        elif(id == 0):
            LightOff()
        return 200

if __name__ == '__main__':
    app = Flask(__name__)
    api = Api(app)
    api.add_resource(LightUpdate, "/light", "/light/", "/light/<int:id>")
    app.run(host="0.0.0.0")
