(defproject sotify "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.2-alpha1"]
                 [cheshire "5.8.1"]
                 [org.clojure/tools.cli "1.0.206"]
                 [org.martinklepsch/clj-http-lite "0.4.3"]]
  :main sotify.core
  :profiles {:uberjar {:aot :all}}
  :repl-options {:init-ns sotify.core})
