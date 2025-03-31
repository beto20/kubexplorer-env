package main

import (
	"encoding/json"
	"fmt"
	"io"
	"net/http"
	"sync"
)

type Schedule struct {
	Day      string `json:"day"`
	Hour     string `json:"hour"`
	Course   string `json:"course"`
	Location string `json:"location"`
}

type Location struct {
	Day     string `json:"day"`
	Course  string `json:"course"`
	Local   string `json:"local"`
	Address string `json:"address"`
}

var (
	mutex sync.Mutex
)

func getLocation() []Location {
	resp, err := http.Get("http://localhost:8080/api/locations")
	if err != nil {
		fmt.Print("Error", err)
	}

	defer resp.Body.Close()

	body, _ := io.ReadAll(resp.Body)

	var locations []Location
	err = json.Unmarshal(body, &locations)
	if err != nil {
		fmt.Print("Error", err)
	}

	fmt.Println("Locations:", locations)

	return locations
}

func getSchedule(w http.ResponseWriter, r *http.Request) {
	mutex.Lock()
	defer mutex.Unlock()

	var schedules []Schedule

	location := getLocation()

	schedule := Schedule{
		Day:      "Monday",
		Hour:     "12:30",
		Course:   "Matematica",
		Location: location[0].Local + " - " + location[0].Address,
	}

	schedules = append(schedules, schedule)

	w.Header().Set("Content-Type", "application/json")

	err := json.NewEncoder(w).Encode(schedules)
	if err != nil {
		return
	}
}

func main() {
	http.HandleFunc("/api/schedules", func(w http.ResponseWriter, r *http.Request) {
		switch r.Method {
		case "GET":
			getSchedule(w, r)
		}
	})

	fmt.Print("Server listening on port 8080")
	err := http.ListenAndServe(":8080", nil)
	if err != nil {
		return
	}
}
