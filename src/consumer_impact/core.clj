(ns consumer-impact.core)

;; Alkali metal,	Alkaline earth metal,	Lan­thanide, Actinide, Transition metal, Post-​transition metal,
;; Polyatomic nonmetal,	Diatomic nonmetal, Noble gas
(defrecord Group [name code])
(defrecord State [name code]) ; solid, liquid, gas, plasma, unknown
(defrecord Source [name code]) ; natural, sythensized, theorized, etc
(defrecord Period [name code]) ;

(defrecord Element [name code atomic_number type state properties])
(defrecord Molecule [name code formula elements])
