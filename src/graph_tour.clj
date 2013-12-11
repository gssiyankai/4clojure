(ns graph_tour)

(use 'clojure.set)

(defn tour
  ([vertex edges]
    (if (empty? edges)
      true
      (let [next-edges (filter #(contains? (set %) vertex) edges)]
        (if (empty? next-edges)
          false
          (true? (some true?
                       (map #(tour (first (difference (set %) #{vertex}))
                                   (difference edges #{%}))
                            next-edges)))
        )
      )
    )
  )
  ([graph]
    (let [edges (set graph)]
      (tour (first (first edges)) edges)
    )
  )
)
