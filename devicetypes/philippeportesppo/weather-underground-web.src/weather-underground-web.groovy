/**
 *  Weather Underground
 *
 *  Copyright 2018 Philippe PORTES
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
 
import groovy.json.JsonSlurper 

metadata {
	definition (name: "Weather Underground Web", namespace: "philippeportesppo", author: "Philippe PORTES") {
		capability "refresh"
        capability "polling"
        capability "sensor"
        capability "capability.temperatureMeasurement"
        capability "capability.relativeHumidityMeasurement"
	}

	tiles(scale: 2) {

	standardTile("UGW_web", "device.UGW_web",  width: 6, height: 3,  canChangeIcon: false ) {
            state "default", icon: "http://icons.wxug.com/graphics/wu2/logo_130x80.png"      }   
             
    standardTile("temperature", "device.temperature", width: 2, height: 2, decoration: "flat", canChangeIcon: false) {
            state "default", label: '${currentValue}º',unit:'${currentValue}', icon: "st.Weather.weather2", backgroundColor:"#e5e9ea"}  
        
	standardTile("humidity", "device.humidity", width: 2, height: 2, decoration: "flat", canChangeIcon: false) {
            state "default", label: '${currentValue}%', icon: "st.Weather.weather12", backgroundColor:"#e5e9ea"      }
            
	standardTile("UGWFeelsLikelevel", "device.UGWFeelsLikelevel",  width: 2, height: 2, decoration: "flat", canChangeIcon: false) {
            state "default",  label: '${currentValue}º',unit:'${currentValue}',icon: "https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/realfeel.png", backgroundColor:"#e5e9ea"}

	standardTile("UGWdewpointlevel", "device.UGWdewpointlevel",  width: 2, height: 2, decoration: "flat", canChangeIcon: false) {
            state "default", label: '${currentValue}º',unit:'${currentValue}',icon: "https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/dewpoint.png", backgroundColor:"#e5e9ea"}
            
    standardTile("UGW_Icon_UrlIcon", "device.UGW_Icon_UrlIcon", decoration: "flat",   width: 2, height: 2) {
                state "chancerain",		icon: "https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/chancerain.png"
                state "chancesleet",	icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/chancesleet.png"
                state "chancesnow",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/chancesnow.png"
                state "chancetstorms",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/chancetstorms.png"
                state "clear",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/clear.png"
                state "cloudy",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/cloudy.png"
                state "flurries",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/flurries.png"
                state "fog",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/fog.png"
                state "hazy",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/hazy.png"
                state "mostlycloudy",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/mostlycloudy.png"
                state "mostlysunny",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/mostlysunny.png"
                state "partlycloudy",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/partlycloudy.png"
                state "partlysunny",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/partlysunny.png"
                state "sleet",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/sleet.png"
                state "rain",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/rain.png"
                state "snow",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/snow.png"
                state "sunny",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/sunny.png"
                state "tstorms",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/tstorms.png"
                state "unknown",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/unknown.png"
                state "nt_chanceflurries",	icon: "https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_chanceflurries.png"	
                state "nt_chancerain",		icon: "https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_chancerain.png"
                state "nt_chancesleet",	icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_chancesleet.png"
                state "nt_chancesnow",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_chancesnow.png"
                state "nt_chancetstorms",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_chancetstorms.png"
                state "nt_clear",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_clear.png"
                state "nt_cloudy",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_cloudy.png"
                state "nt_flurries",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_flurries.png"
                state "nt_fog",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_fog.png"
                state "nt_hazy",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_hazy.png"
                state "nt_mostlycloudy",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_mostlycloudy.png"
                state "nt_mostlysunny",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_mostlysunny.png"
                state "nt_partlycloudy",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_partlycloudy.png"
                state "nt_sleet",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_sleet.png"
                state "nt_rain",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_rain.png"
                state "nt_sleet",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_sleet.png"
                state "nt_snow",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_snow.png"
                state "nt_sunny",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_sunny.png"
                state "nt_tstorms",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_tstorms.png"
	}
            
    standardTile("refresh", "device.refresh", decoration: "flat", width: 2, height: 2) {
 		state "default", action:"refresh", icon:"st.secondary.refresh"
 		} 
	
    standardTile("weather", "device.weather", width: 6, height: 2) {
 		state "default", label:'${currentValue}'
 		} 

    standardTile("wu_main", "device.wu_main", decoration: "flat", width: 6, height: 4) 
    	{
                state "chancerain",		icon: "https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/chancerain.png"
                state "chancesleet",	icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/chancesleet.png"
                state "chancesnow",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/chancesnow.png"
                state "chancetstorms",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/chancetstorms.png"
                state "clear",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/clear.png"
                state "cloudy",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/cloudy.png"
                state "flurries",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/flurries.png"
                state "fog",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/fog.png"
                state "hazy",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/hazy.png"
                state "mostlycloudy",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/mostlycloudy.png"
                state "mostlysunny",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/mostlysunny.png"
                state "partlycloudy",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/partlycloudy.png"
                state "partlysunny",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/partlysunny.png"
                state "sleet",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/sleet.png"
                state "rain",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/rain.png"
                state "snow",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/snow.png"
                state "sunny",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/sunny.png"
                state "tstorms",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/tstorms.png"
                state "unknown",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/unknown.png"
                state "nt_chanceflurries",	icon: "https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_chanceflurries.png"	
                state "nt_chancerain",		icon: "https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_chancerain.png"
                state "nt_chancesleet",	icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_chancesleet.png"
                state "nt_chancesnow",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_chancesnow.png"
                state "nt_chancetstorms",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_chancetstorms.png"
                state "nt_clear",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_clear.png"
                state "nt_cloudy",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_cloudy.png"
                state "nt_flurries",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_flurries.png"
                state "nt_fog",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_fog.png"
                state "nt_hazy",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_hazy.png"
                state "nt_mostlycloudy",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_mostlycloudy.png"
                state "nt_mostlysunny",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_mostlysunny.png"
                state "nt_partlycloudy",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_partlycloudy.png"
                state "nt_sleet",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_sleet.png"
                state "nt_rain",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_rain.png"
                state "nt_sleet",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_sleet.png"
                state "nt_snow",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_snow.png"
                state "nt_sunny",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_sunny.png"
                state "nt_tstorms",icon:"https://raw.githubusercontent.com/philippeportesppo/AirMentorPro2_SmartThings/master/images/nt_tstorms.png"

   		}
	main("wu_main")
	details(["UGW_web","temperature","humidity","UGWFeelsLikelevel","UGWdewpointlevel","UGW_Icon_UrlIcon","weather","refresh" ])
 	}
}

def installed() {
    

}

def updated() {

	log.debug "Executing 'updated'"
   
	refresh()
}

def poll(){
log.debug "Executing 'poll'"
    refresh()
}

String convertTemperature( float temperatureCelcius, unit)
{
	float value = temperatureCelcius
    
    if (unit =="F")
    {
       value = temperatureCelcius * 1.8 + 32.0
    }
    return value.toString().format(java.util.Locale.US,"%.1f", value)
}

// parse events into attributes
def parse(String description) {
	log.debug "Executing 'parse'"
    
   	state.snowalert=false
    state.stormalert=false
    state.rainmalert=false
	state.lowtempalert=false
	state.hightempalert=false
    state.lowhumidityalert=false
    state.highhumidityalert=false    
    refresh()    
    runEvery10Minutes(forcepoll)
    
}

def forcepoll()
{
	refresh()
}

// handle commands
def refresh() {
	log.debug "Executing 'refresh'"
    
    def mymap = getWeatherFeature("conditions")

	/*log.debug "state.snowalert=${state.snowalert}"
    log.debug "state.stormalert=${state.stormalert}"
    log.debug "state.rainmalert=${state.rainmalert}"
    log.debug "state.lowtempalert=${state.lowtempalert}"
    log.debug "state.hightempalert=${state.hightempalert}"
    log.debug "state.lowhumidityalert=${state.lowhumidityalert}"
    log.debug "state.highhumidityalert=${state.highhumidityalert}"*/


    log.debug "response feelslike_c: ${mymap['current_observation']['feelslike_c']}"
    log.debug "response dewpoint_c: ${mymap['current_observation']['dewpoint_c']}"
    log.debug "response relative_humidity: ${mymap['current_observation']['relative_humidity']}"
    log.debug "response temp_c: ${mymap['current_observation']['temp_c']}"
    log.debug "response weather: ${mymap['current_observation']['weather']}"

    //log.debug "Generating events for UX refresh"
    def temperatureScale = getTemperatureScale()

    // UnderGround Weather references
    sendEvent(name: "UGWFeelsLikelevel", value: convertTemperature(mymap['current_observation']['feelslike_c'].toFloat(),temperatureScale), unit: temperatureScale)
    sendEvent(name: "UGWdewpointlevel", value: convertTemperature(mymap['current_observation']['dewpoint_c'].toFloat(),temperatureScale), unit: temperatureScale)
    sendEvent(name: "humidity", value:  mymap['current_observation']['relative_humidity'].substring(0, mymap['current_observation']['relative_humidity'].length()-1))
    sendEvent(name: "temperature", value: convertTemperature(mymap['current_observation']['temp_c'].toFloat(),temperatureScale), unit: temperatureScale)
    sendEvent(name: "UGW_Icon_UrlIcon", value: mymap['current_observation']['icon_url'].substring(28,mymap['current_observation']['icon_url'].length()-4))
    sendEvent(name: "wu_main", value: mymap['current_observation']['icon_url'].substring(28,mymap['current_observation']['icon_url'].length()-4))
    sendEvent(name:"weather", value: mymap['current_observation']['weather'], display:true, isStateChange: true)


    if (getDataValue("wusnowalert")=="True" && mymap['current_observation']['icon_url'].contains("snow"))
    {
        // if ( state.snowalert == false) {
            sendEvent(name:"Alert", value: "WUW Snow Alert!", display:true)
        //    state.snowalert=true  }
    }
    else
        state.snowalert=false

    if (getDataValue("wurainalert")=="True" && mymap['current_observation']['icon_url'].contains("rain"))
    {
        // if ( state.rainalert == false) {
            sendEvent(name:"Alert", value: "WUW Rain Alert!", display:true)
        //    state.rainalert=true  }
    }
    else
        state.rainalert=false

    if (getDataValue("wustormalert")=="True" && mymap['current_observation']['icon_url'].contains("rain"))
    {
        // if ( state.stormalert == false) {
            sendEvent(name:"Alert", value: "WUW Storm Alert!", display:true)
        //    state.stormalert=true  }
    }
    else
        state.stormalert=false

    if (getDataValue("wulowtempalert")!="null") {
        if (getDataValue("wulowtempalert").toFloat() >= convertTemperature(mymap['current_observation']['temp_c'].toFloat(),temperatureScale).toFloat())
        {

            //if ( state.lowtempalert == false) {
                sendEvent(name:"Alert", value: "WUW Low Temperature Alert!", display:true)
            //    state.lowtempalert=true }
        }
        else
            state.lowtempalert=false
    }

    if (getDataValue("wuhightempalert")!="null") {
        if (getDataValue("wuhightempalert").toFloat() <= convertTemperature(mymap['current_observation']['temp_c'].toFloat(),temperatureScale).toFloat())
        {

            //if ( state.hightempalert == false) {
                sendEvent(name:"Alert", value: "WUW High Temperature Alert!", display:true)
            //    state.hightempalert=true }
        }
        else
            state.hightempalert=false
    }

    if (getDataValue("wulowhumidityalert")!="null") {
        if (getDataValue("wulowhumidityalert").toFloat() >= mymap['current_observation']['relative_humidity'].substring(0, mymap['current_observation']['relative_humidity'].length()-1).toFloat())
        {

            //if ( state.lowhumidityalert == false) {

                sendEvent(name:"Alert", value: "WUW Low Humidity Alert!", display:true)
            //    state.lowhumidityalert=true }
        }
        else
        {
            state.lowhumidityalert=false

        }
    }

    if (getDataValue("wuhighhumidityalert")!="null") {

        if (getDataValue("wuhighhumidityalert").toFloat() <= mymap['current_observation']['relative_humidity'].substring(0, mymap['current_observation']['relative_humidity'].length()-1).toFloat())
        {
            //if ( state.highhumidityalert == false) {
                sendEvent(name:"Alert", value: "WUW High Humidity Alert!", display:true)
            //    state.highhumidityalert=true }
        }
        else
            state.highhumidityalert=false
    }

}    