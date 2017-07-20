(ns consumer-impact.model.data)

; todo: Rely on GraphQl (lacinia) to adapt this information into specific querie results

;; Load molecular database information
; datomic or postgresql

;; Load Producer database information
; datomic

;; Load product database information
; datomic

(def molecule-schema
  [{:db/doc "A molecule name"
    :db/ident :molecule/name
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db.install/_attribute :db.part/db},
   {:db/doc "A molecule formula"
    :db/ident :molecule/formula
    :db/valueType :db.type/string

    :db/cardinality :db.cardinality/one
    :db.install/_attribute :db.part/db},
   {:db/doc "Discovery date"
    :db/id :molecule/discovery_date
    :db/valueType :db.type/instant
    :db/cardinality :db.cardinality/one
    :db.install/_attribute :db.part/db
    },
   {:db/doc "Entered date"
    :db/id :molecule/entered_date
    :db/valueType :db.type/instant},
   {:db/doc "Discovered by"},
   {:db/doc "Properties"}
   ])
