
    // Note: This example requires that you consent to location sharing when
    // prompted by your browser. If you see the error "The Geolocation service
    // failed.", it means you probably did not give permission for the browser to
    // locate you.
    let map, infoWindow, geocoder;

    function initMap() {
    map = new google.maps.Map(document.getElementById("map"), {
        center: { lat: 29.4241, lng: -98.4936 },
        zoom: 10,
    });
    geocoder = new google.maps.Geocoder();
    document.getElementById("submit").addEventListener("click", () => {
    geocodeAddress(geocoder, map);
});
    infoWindow = new google.maps.InfoWindow();

    //test POIs
    const poiList = [
{
    "latLng":  { lat: 29.44, lng: -98.5 },
    "title": "Test1",
    "type": "Bar/Restaurant",
    "description": "A biker-friendly bar"
},
{
    "latLng": { lat: 29.42, lng: -98.48},
    "title": "Test2",
    "type": "Scenic View",
    "description": "nice view"
},
{
    "latLng": { lat: 29.425, lng: -98.49},
    "title": "Test3",
    "type": "Repair Shop",
    "description": "They know what they're doing"
}
    ];

    const iconBase = "http://maps.google.com/mapfiles/kml/pal2/";

    const icons = {
    "Bar/Restaurant": {
    icon: iconBase + "icon32.png"
},
    "Scenic View": {
    icon: iconBase + "icon4.png"
},
    "Repair Shop": {
    icon: iconBase + "icon21.png"
}
}

    //Pan to current location button
    const locationButton = document.createElement("button");
    locationButton.textContent = "Pan to Current Location";
    locationButton.classList.add("custom-map-control-button");
    map.controls[google.maps.ControlPosition.TOP_RIGHT].push(locationButton);
    locationButton.addEventListener("click", () => {
    // Try HTML5 geolocation.
    if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(
    (position) => {
    const pos = {
    lat: position.coords.latitude,
    lng: position.coords.longitude,
};
    infoWindow.setPosition(pos);
    infoWindow.setContent("Location found.");
    infoWindow.open(map);
    map.setCenter(pos);
},
    () => {
    handleLocationError(true, infoWindow, map.getCenter());
}
    );
} else {
    // Browser doesn't support Geolocation
    handleLocationError(false, infoWindow, map.getCenter());
}
});

    //For each POI, add it to the map
    poiList.forEach(function(poi) {
    drawPOIs(poi, icons, infoWindow, map);
});
}

    //If GeoLocation fails
    function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(
    browserHasGeolocation
    ? "Error: The Geolocation service failed."
    : "Error: Your browser doesn't support geolocation."
    );
    infoWindow.open(map);
}

    //Geocoder, searches for input location and centers map on it
    function geocodeAddress(geocoder, resultsMap) {
    const address = document.getElementById("address").value;
    geocoder.geocode({address: address}, (results, status) => {
    if (status === "OK") {
    resultsMap.setCenter(results[0].geometry.location);
    //Commented out lines set a marker on the location, unsure if we want that or not
    // new google.maps.Marker({
    //     map: resultsMap,
    //     position: results[0].geometry.location,
    // });
} else {
    alert(
    "Geocode was not successful for the following reason: " + status
    );
}
});
}

    //Adds markers for the POIs on the map and assigns their infowindow information
    function drawPOIs(poi, icons, infoWindow, map) {
    //For each POI, add to map
    let marker = new google.maps.Marker({
    position: poi.latLng,
    title: poi.title,
    //Looks at the poi type and references the icon array to determine what icon it uses
    icon: icons[poi.type].icon
});
    marker.setMap(map);
    //This connects the info window to the marker, allowing information, links, etc. to be displayed
    google.maps.event.addListener(marker, 'click', function() {
    infoWindow.setContent("<h4> Title: " + poi.title + "</h4>" +
    "<p>Description: " + poi.description + "</p>");
    infoWindow.open(map, marker);
});
}
