//TODO: move to another utility class
Ext.Date.patterns = {
	    ISO8601Long:"d/m/Y H:i:s",
	    ISO8601LongTimeZone:"Y-m-d H:i:s P",
	    ISO8601Short:"d/m/Y",
	    ShortDate: "n/j/Y",
	    LongDate: "l, F d, Y",
	    FullDateTime: "l, F d, Y g:i:s A",
	    MonthDay: "F d",
	    ShortTime: "g:i A",
	    LongTime: "g:i:s A",
	    SortableDateTime: "Y-m-d\\TH:i:s",
	    UniversalSortableDateTime: "Y-m-d H:i:sO",
	    YearMonth: "F, Y"
	};

// function to calculate local time
// in a different city
// given the city's UTC offset
Ext.Date.calcTime=function(offset) {

    // create Date object for current location
    d = new Date();
    
    // convert to msec
    // add local time zone offset 
    // get UTC time in msec
    utc = d.getTime() + (d.getTimezoneOffset() * 60000);
    
    // create new Date object for different city
    // using supplied offset
    nd = new Date(utc + (3600000*offset));
    
    // return time as a string
    //return "The local time in is " + nd.toLocaleString();
    return nd;

}
function WorldClock(zone){
	now=new Date();
	ofst=now.getTimezoneOffset()/60;
	secs=now.getSeconds();
	sec=-1.57+Math.PI*secs/30;
	mins=now.getMinutes();
	min=-1.57+Math.PI*mins/30;
	hr=(now.getHours() + parseInt(ofst)) + parseInt(zone);
	hrs=-1.575+Math.PI*hr/6+Math.PI*parseInt(now.getMinutes())/360;
	if (hr < 0) hr+=24;
	if (hr > 23) hr-=24;
	ampm = (hr > 11)?"PM":"AM";
	statusampm = ampm.toLowerCase();
	
	hr2 = hr;
	if (hr2 == 0) hr2=12;
	(hr2 < 13)?hr2:hr2 %= 12;
	if (hr2<10) hr2="0"+hr2
	
	var finaltime=hr2+':'+((mins < 10)?"0"+mins:mins)+':'+((secs < 10)?"0"+secs:secs)+' '+statusampm;
	
	return finaltime;
}