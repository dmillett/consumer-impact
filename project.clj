(defproject consumer-impact "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://www.consumer-impact.org/FIXME"
  :license {:name "GNU Lesser General Public License, version 2.1"
            :url "https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [frinj "0.2.5"]
                 [com.datomic/datomic-free "0.9.5697"]]
  :plugins [[lein-kibit "0.1.3"]
            [jonase/eastwood "0.2.3"]
            [lein-ancient "1.0.0-RC3"]
            [com.walmartlabs/lacinia "0.14.0"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :repl-options {:init (do
                         (use 'consumer-impact.core)
                         (use 'consumer-impact.periodic)
                         (use 'consumer-impact.molecule)
                         (use 'consumer-impact.tools)
                         (use 'consumer-impact.conversion)
                         (require '[consumer-impact.conversions :as cvrs])
                         (println "Loaded 'consumer-impact' repl resources")
                         )})
