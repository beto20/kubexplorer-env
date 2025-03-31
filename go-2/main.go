package main

import (
	"encoding/json"
	"fmt"
	"net/http"
	"sync"
)

type Location struct {
	Day     string `json:"day"`
	Course  string `json:"course"`
	Local   string `json:"local"`
	Address string `json:"address"`
}

var (
	mutex sync.Mutex
)

func getSchedule(w http.ResponseWriter, r *http.Request) {
	mutex.Lock()
	defer mutex.Unlock()

	var locations []Location

	location := Location{
		Day:     "Monday",
		Course:  "Matematica",
		Local:   "Lima",
		Address: "Barranco",
	}

	locations = append(locations, location)

	w.Header().Set("Content-Type", "application/json")

	err := json.NewEncoder(w).Encode(locations)
	if err != nil {
		return
	}
}

func main() {
	http.HandleFunc("/api/locations", func(w http.ResponseWriter, r *http.Request) {
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
