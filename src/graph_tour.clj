(ns graph_tour)

(use 'clojure.set)

(defn tour
  ([src edges]
    (let [endpoint (fn [edge src]
                     (cond
                       (= src (first edge)) (second edge)
                       (= src (second edge)) (first edge)
                       :else nil
                     ))]
      (if (empty? edges)
        src
        (->> (map #(list (endpoint % src) %) edges)
             (filter #(not (nil? (first %))))
             (map #(tour (first %) (difference edges #{(second  %)})))
        )
      )
    )
  )
  ([edges]
    (= true
       (->> (map #(or
                    (= (list (second %)) (tour (first %) (set edges)))
                    (= (list (first %)) (tour (second %) (set edges)))
                  )
                  (set edges))
            (some true?)
       )
    )
  )
)
