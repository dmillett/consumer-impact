(ns consumer-impact.periodic)

;; Alkali metal,	Alkaline earth metal,	Lan­thanide, Actinide, Transition metal, Post-​transition metal,
;; Polyatomic nonmetal,	Diatomic nonmetal, Noble gas
(defrecord Category [name])
(def categories {:diatomic_nonmetal (->Category "Diatomic nonmetal")
                 :noble_gas (->Category "Noble gas")
                 :polyatomic_nonmetal (->Category "Polyatomic nonmetal")
                 :superactinide (->Category "Superactinide")
                 :post_transition_nonmetal (->Category "Post-transition metal")
                 :metalloids (->Category "Metalloids")
                 :alkali_metal (->Category "Alkali metal")
                 :alkali_earth_metal (->Category "Alkaline earth metal")
                 :pnictogen (->Category "Pnictogen")
                 :chalcogen (->Category "Chalcogen")
                 :halogen (->Category "Halogen")
                 :lanthanoid (->Category "Lanthanoid")
                 :actinoid (->Category "Actinoid")
                 :rare_earth_metal (->Category "Rare earth metal")
                 :transition_metal (->Category "Transition metal")})

(defrecord State [name description]) ; solid, liquid, gas, plasma, unknown
(def states {:solid (->State "solid" "Stable, defined shape and volume")
             :liquid (->State "liquid" "A nearly incompressible fluid with no defined shape")
             :gas (->State "gas" "A compressible fluid with no defined shape")
             :plasma (->State "plasma" "No defined shape, electrically conductive, and respond to electromagnetism")
             :unknown (->State "unkown" "Unknown what state the element does/can exist in.")})

; Can make 'description' a {} with locale and translations
(defrecord Source [name description])
(def sources {:natural (->Source "natural" "An element naturally occuring in nature.")
              :synthesized (->Source "synthesized" "An element created in a laboratory.")
              :theorized (->Source "theorized" "An element thought to exist from scientific proof.")})

(defrecord Element [name symbol anumber aweight group period category state source properties])

; http://www.ptable.com/
; https://en.wikipedia.org/wiki/Periodic_table
(def table
  {:H (->Element "Hydrogen" "H" 1, 1.008, 1, 1 (:diatomic_nonmetal categories) (:gas states) (:natural sources) [])
   :He (->Element "Helium" "He" 2, 4.002602, 18, 1 (:noble_gas categories) (:gas states) (:natural sources) [])
   :Li (->Element "Lithium" "Li" 3, 6.94, 1, 2 (:alkali_metal categories) (:solid states) (:natural sources) [])
   :Be (->Element "Beryllium" "Be" 4, 9.012182, 2, 2 (:alkali_earth_metal categories) (:solid states) (:natural sources) [])
   :B (->Element "Boron" "B" 5, 10.81, 2, 13 (:metalloids categories) (:solid states) (:natural sources) [])
   })