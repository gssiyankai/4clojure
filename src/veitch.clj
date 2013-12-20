(ns veitch)

(use 'clojure.set)

(defn simplify [inputs]
  (let [filter-candidates (fn [input candidates]
                            (->> (filter #(= (count input) (count %)) candidates)
                                 (filter #(= (dec (count input)) (count (intersection input %))))))
        filter-inputs (fn [input candidate] (intersection))
        simplified-inputs (->> (map #(vector % (disj inputs %)) inputs)
                               (map #(vector (first %) (first (filter-candidates (first %) (second %)))))
                               (map #(if (empty? (second %))
                                       (first %)
                                       (apply intersection %)))
                               (into #{}))]
    (if (= inputs simplified-inputs)
      inputs
      (simplify simplified-inputs))
  )
)
