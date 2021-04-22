(ns sotify.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clj-http.lite.client :as client]
            [cheshire.core :refer [generate-string]])
  (:gen-class))

(set! *warn-on-reflection* true)

(defn usage [options-summary]
  (->> ["Slack notification tool."
        "Usage: sotify -u http://slack.hook -m \"Custom message\" "
        ""
        "Options:"
        options-summary]
       (clojure.string/join \newline)))

(def cli-options
  [["-u" "--url URL" "Slack webhook url"]
   ["-m" "--message MESSAGE" "A custom message"]
   ["-c" "--channel CHANNEL" "Slack channel, example: #channel or @username"]
   ["-h" "--help"]])

(defn exit [message]
  (println message)
  (System/exit 0))

(defn exit-error [message]
  (println message)
  (System/exit 1))

(defn make-slack-request [{:keys [url message channel]}]
  (let [body (into {} [[:text message]
                       (when channel [:channel channel])])]
    (client/post url
                 {:content-type "application/json"
                  :body (generate-string body)})))

(defn -main
  [& args]
  (let [{:keys [options errors summary]} (parse-opts args cli-options)]
    (cond
      errors (exit-error (->> errors (clojure.string/join \newline)))
      (:help options) (exit (usage summary))
      (nil? (:url options)) (exit-error "Please provide an url")
      (nil? (:message options)) (exit-error "Please provide a message")
      :else (make-slack-request options))))
