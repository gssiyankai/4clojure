(ns sum_some_set_subsets)

(use 'clojure.set)

(defn sum [& sets]
  (let [subsets (fn [set]
                  (reduce (fn [acc i]
                            (clojure.set/union acc
                                               #{#{i}}
                                               (map (fn [a] (conj a i)) acc)))
                          #{}
                          set))
        subsets-sum (fn [subsets]
                      (reduce (fn [acc i]
                                (conj acc (reduce + 0 i)))
                              #{}
                              subsets))]
    (->> (map subsets sets)
         (map subsets-sum)
         (apply clojure.set/intersection)
         (empty?)
         (not)
    )
  )
)
