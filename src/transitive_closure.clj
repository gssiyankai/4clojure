(ns transitive_closure)

(use 'clojure.set)

(defn matching-relations [relations pair f1 f2]
  (filter (fn [relation] (= (f1 pair) (f2 relation))) relations)
)

(defn add-relation [relations pair f f1 f2]
  (reduce
    (fn [acc relation]
      (conj acc (f [(f1 relation) (f2 pair)])))
    relations
    (matching-relations relations pair f1 f2))
)

(defn generate [relations]
  (reduce
    (fn [relations pair]
      (let [relations-1 (add-relation relations pair identity first second)
            relations-2 (add-relation relations pair reverse second first)]
        (clojure.set/union relations-1 relations-2 #{pair})
        )
    )
    #{}
    relations)
)
