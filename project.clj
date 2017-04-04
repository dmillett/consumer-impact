(defproject consumer-impact "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [frinj "0.2.5"]]
  :plugins [[lein-kibit "0.1.3"]
            [jonase/eastwood "0.2.3"]
            [lein-ancient "0.6.10"]
            [com.walmartlabs/lacinia "0.14.0"]]
  :jvm-opts ["-Xms256m" "-Xmx256m"]
  :repl-options {:init (do
                         (use 'consumer-impact.core)
                         (use 'consumer-impact.periodic)
                         (use 'consumer-impact.tools)
                         (println "Loaded 'consumer-impact' repl resources")
                         )})
