(ns veitch)

(use 'clojure.set)

(defn simplify [inputs]
  (let [functions {'A 'a, 'a 'A, 'B 'b, 'b 'B, 'C 'c, 'c 'C, 'D 'd, 'd 'D}
        filter-candidates (fn [input candidates]
                            (->> (filter #(= (count input) (count %)) candidates)
                                 (filter #(= (dec (count input)) (count (intersection input %))))
                                 (filter #(contains? % (functions (first (difference input %)))))))
        simplified-inputs (->> (map #(vector % (disj inputs %)) inputs)
                               (map #(vector (first %) (first (filter-candidates (first %) (second %)))))
                               (map #(if (empty? (second %))
                                       (first %)
                                       (apply intersection %)))
                               (sort #(compare (count %1) (count %2)))
                               (reduce (fn [acc i] (if (some #(subset? % i) acc)
                                                     acc
                                                     (conj acc i)))
                                       #{}))]
    (if (= inputs simplified-inputs)
      inputs
      (simplify simplified-inputs))
  )
)
