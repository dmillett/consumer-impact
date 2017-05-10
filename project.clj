(defproject consumer-impact "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://www.consumer-impact.org/FIXME"
  :license {:name "GNU Lesser General Public License, version 2.1"
            :url "https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [frinj "0.2.5"]]
  :plugins [[lein-kibit "0.1.3"]
            [jonase/eastwood "0.2.3"]
            [lein-ancient "0.6.10"]
            [com.walmartlabs/lacinia "0.14.0"]
            [com.datomic/datomic-free "0.9.5561"]]
  :jvm-opts ["-Xms256m" "-Xmx256m"]
  :repl-options {:init (do
                         (use 'consumer-impact.core)
                         (use 'consumer-impact.periodic)
                         (use 'consumer-impact.molecule)
                         (use 'consumer-impact.tools)
                         (println "Loaded 'consumer-impact' repl resources")
                         )})
