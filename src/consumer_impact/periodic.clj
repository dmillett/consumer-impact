(ns consumer-impact.periodic)

;; Alkali metal,	Alkaline earth metal,	Lan­thanide, Actinide, Transition metal, Post-​transition metal,
;; Polyatomic nonmetal,	Diatomic nonmetal, Noble gas
(defrecord Category [name])
(def categories {:diatomic_nonmetal (->Category "Diatomic nonmetal")
                 :noble_gas (->Category "Noble gas")
                 :polyatomic_nonmetal (->Category "Polyatomic nonmetal")
                 :superactinide (->Category "Superactinide")
                 :post_transition_metal (->Category "Post-transition metal")
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
(def phases {:solid   (->State "solid" "Stable, defined shape and volume")
             :liquid  (->State "liquid" "A nearly incompressible fluid with no defined shape")
             :gas     (->State "gas" "A compressible fluid with no defined shape")
             :plasma  (->State "plasma" "No defined shape, electrically conductive, and respond to electromagnetism")
             :unknown (->State "unkown" "Unknown what state the element does/can exist in.")})

; Can make 'description' a {} with locale and translations
(defrecord Source [name description])
(def sources {:natural (->Source "natural" "An element naturally occuring in nature.")
              :synthesized (->Source "synthesized" "An element created in a laboratory.")
              :theorized (->Source "theorized" "An element thought to exist from scientific proof.")})

(defrecord Element [name anumber aweight group period category origin properties])

; http://www.ptable.com/
; https://en.wikipedia.org/wiki/Periodic_table
; todo: fill out :origins in more detail for all element states
; todo: fill out :properties by states
(def table
  ;; Group 1
  {:H (->Element "Hydrogen" 1, 1.008, 1, 1 (:diatomic_nonmetal categories) {(:gas phases) (:natural sources)} {})
   :He (->Element "Helium" 2, 4.002602, 18, 1 (:noble_gas categories) {(:gas phases) (:natural sources)} {})
   ;: Group 2
   :Li (->Element "Lithium" 3, 6.94, 1, 2 (:alkali_metal categories) {(:solid phases) (:natural sources)} {})
   :Be (->Element "Beryllium" 4, 9.012182, 2, 2 (:alkali_earth_metal categories) {(:solid phases) (:natural sources)} {})
   :B (->Element "Boron" 5, 10.81, 2, 13 (:metalloids categories) {(:solid phases) (:natural sources)} {})
   :C (->Element "Carbon" 6, 12.011, 2, 14 (:polyatomic_nonmetal categories) {(:solid phases) (:natural sources)} {})
   :N (->Element "Nitrogen" 7, 14.007, 2, 15 (:polyatomic_nonmetal categories) {(:gas phases) (:natural sources)} {})
   :O (->Element "Oxygen" 8, 15.999, 2, 16 (:polyatomic_nonmetal categories) {(:gas phases) (:natural sources)} {})
   :F (->Element "Flourine" 9, 18.998, 2, 17 (:halogen categories) {(:gas phases) (:natural sources)} {})
   :Ne (->Element "Neon" 10, 20.1797, 2, 18 (:noble_gas categories) {(:gas phases) (:natural sources)} {})
   ;; Group 3
   :Na (->Element "Sodium", 11, 22.989, 3, 1 (:alkali_metal categories) {(:solid phases) (:natural sources)} {})
   :Mg (->Element "Magnesium" 12, 24.305, 3, 2 (:alkali_earth_metal categories) {(:solid phases) (:natural sources)} {})
   :Al (->Element "Aluminum" 13 26.981, 3, 13 (:post_transition_metal categories) {(:solid phases) (:natural sources)} {})
   :Si (->Element "Silicon" 14, 28.085, 3, 14 (:metalloids categories) {(:solid phases) (:natural sources)} {})
   :P (->Element "Phosphorus" 15, 30.973, 3, 15 (:polyatomic_nonmetal categories) {(:solid phases) (:natural sources)} {})
   :S (->Element "Sulfur" 16, 32.06, 3, 16 (:polyatomic_nonmetal categories) {(:solid phases) (:natural sources)} {})
   :Cl (->Element "Chlorine" 17, 35.45, 3, 17 (:halogen categories) {(:gas phases) (:natural sources)} {})
   :Ar (->Element "Argon" 18, 39.948, 3, 18 (:noble_gas categories) {(:gas phases) (:natural sources)} {})
   ;; Group 4
   :K (->Element "Potassium" 19, 39.0983, 4, 1 (:alkali_metal categories) {(:solid phases) (:natural sources)} {})
   :Ca (->Element "Calcium" 20, 40.078, 4, 2 (:alkali_earth_metal categories) {(:solid phases) (:natural sources)} {})
   :Sc (->Element "Scandium" 21, 44.955912, 4, 3 (:transition_metal categories) {(:solid phases) (:natural sources)} {})
   :Ti (->Element "Titanium" 22, 47.867, 4, 4 (:transition_metal categories) {(:solid phases) (:natural sources)} {})
   :V (->Element "Vanadium" 23, 50.9145, 4, 5 (:transition_metal categories) {(:solid phases) (:natural sources)} {})
   :Cr (->Element "Chromium" 24, 51.9961, 4, 6 (:transition_metal categories) {(:solid phases) (:natural sources)} {})
   :Mn (->Element "Manganese" 25, 54.938045, 4, 7 (:transition_metal categories) {(:solid phases) (:natural sources)} {})
   :Fe (->Element "Iron" 26, 55.845, 4, 8 (:transition_metal categories) {(:solid phases) (:natural sources)} {})
   :Co (->Element "Cobalt" 27, 58.933195, 4, 9 (:transition_metal categories) {(:solid phases) (:natural sources)} {})
   :Ni (->Element "Nickel" 28, 58.6934, 4, 10 (:transition_metal categories) {(:solid phases) (:natural sources)} {})
   :Cu (->Element "Copper" 29, 63.546, 4, 11 (:transition_metal categories) {(:solid phases) (:natural sources)} {})
   :Zn (->Element "Zinc" 30, 65.38, 4, 12 (:transition_metal categories) {(:solid phases) (:natural sources)} {})
   })