(ns transitive_closure)

(defn add-relation [relations pair]
  (conj
    (reduce (fn [acc relation] (conj acc [(first relation) (second pair)])) relations
      (filter (fn [relation] (= (first pair) (second relation))) relations))
        [(first pair) (second pair)])
)

(defn add-relation-2 [relations pair]
  (conj
    (reduce (fn [acc relation] (conj acc [(first pair) (second relation)])) relations
      (filter (fn [relation] (= (second pair) (first relation))) relations))
    [(first pair) (second pair)])
  )

(defn generate [relation]
  (reduce (fn [acc i] (add-relation-2 (add-relation acc i) i)) #{} relation)
)
