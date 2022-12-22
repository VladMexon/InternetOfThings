from flask import Flask
from flask_restful import Api, Resource
import requests

lightStatus = False
class LightUpdate(Resource):
    global lightStatus
    def post(self, id=0):
       if (id == 1):
        lightStatus = True
        print("on")
       elif(id == 0):
        print("off")
        lightStatus = False
       elif(id == 2):
        lightStatus = not lightStatus
        print("switch to different")
    def get(self):
        return lightStatus, 200

if __name__ == '__main__':
    app = Flask(__name__)
    api = Api(app)
    api.add_resource(LightUpdate, "/light", "/light/", "/light/<int:id>")
    app.run()