# Datomic setup

## Datomic (free)

1. Get Datomic
```bash
# Get datomic free (latest) https://my.datomic.com/downloads/free
local version=0.9.5561.50
unzip datomic-free-$version.zip
```
2. Start Transactor
```bash
# Start the transactor
cd datomic-free-$version

# Update memory settings and port(s) here
bin/transactor config/sample/free-transactor-template.properties
```
3. Create/update project.clj
```clojure
:dependencies [[com.datomic/datomic-free "0.9.5561.50"]]

; Otherwise Datomic will complain about memory
:jvm-opts ^:replace ["-Xmx1g" "-server"]
```
4. Start the repl and create a database
   - put schemas in **resources/schema**
   - put test data in **/test/data**
```bash
lein repl
```
```clojure
(require '[datomic.api :as d])

;; Create a db on default url:port
(def db-molecules "datomic:free://localhost:4334/molecules")
(d/create-database db-molecules)
```

5. Add a schema

Here is sample from **resources/schema/molecules-sample.edn**
```clojure
[{:db/id #db/id[:db.part/db]
  :db/doc "The molecule formula"
  :db/ident :molecule/formula
  :db/valueType :db.type/string
  :db/unique :db.unique/value
  :db/cardinality :db.cardinality/one
  :db/index true
  :db.install/_attribute :db.part/db}]
```
```clojure
;; A stateful connection to the db
(def conn-mols (d/connect db-molecules))

(def schema-data "/project-path/resources/schema/molecules-sample.edn")
(def schema-moles (read-string (slurp schema-data)))

;; Add schema to db
; (d/transact conn-mols schema-mols)
(-> db-molecules d/connect (d/transact schema-moles))

;; Schema upload result
;#object[datomic.promise$settable_future$reify__1510 0x3bfd2d7 
; {:status :ready, 
;  :val {:db-before datomic.db.Db@95026b7c, 
;        :db-after datomic.db.Db@8587d4c3, 
;        :tx-data 
;          [#datom[13194139534312 50 #inst "2017-07-19T16:26:47.558-00:00" 13194139534312 true] 
;           #datom[63 62 "The molecular formula, as text, parsable by consumer-impact" 13194139534312 true] 
;           #datom[63 10 :molecule/formula 13194139534312 true] 
;           #datom[63 42 38 13194139534312 true] 
;           #datom[63 40 23 13194139534312 true] 
;           #datom[63 41 35 13194139534312 true] 
;           #datom[63 44 true 13194139534312 true] 
;           #datom[0 13 63 13194139534312 true] 
;           #datom[64 62 "The molecule name" 13194139534312 true] 
;           #datom[64 10 :molecule/name 13194139534312 true] 
;           #datom[64 40 23 13194139534312 true] 
;           #datom[64 41 35 13194139534312 true] 
;           #datom[64 44 true 13194139534312 true] 
;           #datom[0 13 64 13194139534312 true]], 
; :tempids {-9223367638809264704 63, -9223367638809264705 64}}}]
```
6.
```clojure
;; Create and add data
(def h2o [{:molecule/formula "H2O"}])
(-> db-molecules d/connect (d/transact h2o))

;#object[datomic.promise$settable_future$reify__1510 0x1d2de06b 
; {:status :ready, 
;  :val {:db-before datomic.db.Db@af7bd05c, 
;        :db-after datomic.db.Db@de56a986, 
;        :tx-data 
;          [#datom[13194139534313 50 #inst "2017-07-19T16:37:19.727-00:00" 13194139534313 true] 
;           #datom[17592186045418 63 "H2O" 13194139534313 true] 
;           #datom[17592186045418 64 "Water" 13194139534313 true]], 
; :tempids {-9223301668109598142 17592186045418}}}]
```