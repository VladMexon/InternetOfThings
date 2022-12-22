from flask import Flask
from flask_restful import Api, Resource

def LightOn(): #включить свет
    print("light turned on")

def LightOff(): #выключить свет
    print("light turned off")

def GetLightStatus(): #получить статус света
    print("status was sent")
    return False


class LightUpdate(Resource):
    def post(self, id=0):
       if (id == 1):
        LightOn()
       elif(id == 0):
        LightOff()
       elif(id == 2):
        if(GetLightStatus()):
            LightOff()
        else:
            LightOn()
    def get(self):
        return GetLightStatus(), 200

if __name__ == '__main__':
    app = Flask(__name__)
    api = Api(app)
    api.add_resource(LightUpdate, "/light", "/light/", "/light/<int:id>")
    app.run()