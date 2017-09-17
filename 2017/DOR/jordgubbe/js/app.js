var app = angular.module("myApp", []);

app.controller("myCtrl", function($scope, $http) {

    $scope.items = [{
        "name": "Facebook",
        "link": "https://www.facebook.com/",
        "colour": "red"
    }, {
        "name": "Sonarr",
        "link": "https://sonarr.tv/",
        "colour": "cyan"
    }, {
        "name": "GitHub",
        "link": "https://github.com/emimontesdeoca",
        "colour": "deep-purple"
    }, {
        "name": "Gmail",
        "link": "https://mail.google.com",
        "colour": "green"
    }, {
        "name": "Youtube",
        "link": "https://www.youtube.com/",
        "colour": "purple"
    }, {
        "name": "Reddit",
        "link": "https://www.reddit.com/r/homelab/",
        "colour": "yellow"
    }, {
        "name": "Deluge",
        "link": "http://deluge-torrent.org/",
        "colour": "blue"
    }, {
        "name": "Batoto",
        "link": "http://bato.to/",
        "colour": "orange"
    }, {
        "name": "GitLab",
        "link": "https://www.youtube.com/",
        "colour": "green"
    }, {
        "name": "Yahoo",
        "link": "https://www.reddit.com/r/homelab/",
        "colour": "cyan"
    }, {
        "name": "Guacamole",
        "link": "https://sonarr.tv/",
        "colour": "red"
    }, {
        "name": "r/Homelab",
        "link": "https://github.com/emimontesdeoca",
        "colour": "yellow"
    },{
        "name": "Dropbox",
        "link": "https://www.facebook.com/",
        "colour": "red"
    }, {
        "name": "uTorrent",
        "link": "https://sonarr.tv/",
        "colour": "yellow"
    }, {
        "name": "FTPServer",
        "link": "https://github.com/emimontesdeoca",
        "colour": "deep-purple"
    }, {
        "name": "NAS",
        "link": "https://mail.google.com",
        "colour": "green"
    }]
    $scope.config = {"pageTitle": "jordgubbe",
    "pageHeader": "jordgubbe",
    "weatherEnable": true,
    "weatherLocation": "Tenerife"}

    // Weather stuff, if it is enable
    $(document).ready(function() {
        loadWeather('tenerife', '');
    });
    // Weather function
    function loadWeather(location, woeid) {
        $.simpleWeather({
            location: location,
            woeid: woeid,
            unit: 'c',
            success: function(weather) {
                html = weather.city + ', ' + weather.region + ' - ' + weather.temp + '&deg;' + weather.units.temp;
                $("#weather").html(html);
            },
            error: function(error) {
                $("#weather").html('<p>' + error + '</p>');
            }
        });
    }
});
