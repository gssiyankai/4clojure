(ns transitive_closure)

(defn matching-relations [relations pair f1 f2]
  (filter (fn [relation] (= (f1 pair) (f2 relation))) relations)
)

(defn add-relation-1 [relations pair]
  (reduce
    (fn [acc relation]
      (conj acc [(first relation) (second pair)]))
    relations
    (matching-relations relations pair first second))
)

(defn add-relation-2 [relations pair]
  (reduce
    (fn [acc relation]
      (conj acc [(first pair) (second relation)]))
    relations
    (matching-relations relations pair second first))
  )

(defn generate [relations]
  (reduce
    (fn [relations pair]
      (conj (add-relation-2 (add-relation-1 relations pair) pair) pair))
      #{}
    relations)
)
