(ns graph_connectivity)

(defn connected [graph]
  (let [vertices (set (apply concat graph))
        connected-vertices (fn connected-vertices
                             ([vertex] (connected-vertices vertex #{}))
                             ([vertex cache]
                               (let [adjacent-vertices (->> (apply concat (filter #(contains? (set %) vertex) graph))
                                                            (filter #(not (contains? cache %)))
                                                       )]
                                 (if (empty? adjacent-vertices)
                                   cache
                                   (set (mapcat #(connected-vertices % (set (conj cache %))) adjacent-vertices))
                                 )
                               )
                             )
                           )
       ]
    (every? #(= vertices (connected-vertices %)) vertices)
  )
)