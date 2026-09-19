package org.two.pointer;

public class Celebrity {
        public int celebrity(int mat[][]) {
            int n = mat.length;

            int left = 0;
            int right = n - 1;

            // Find a potential celebrity
            while (left < right) {
                if (mat[left][right] == 1) {
                    // left knows right, so left can't be celebrity
                    left++;
                } else {
                    // left doesn't know right, so right can't be celebrity
                    right--;
                }
            }

            int candidate = left;

            // Verify candidate
            for (int i = 0; i < n; i++) {
                if (i == candidate) {
                    continue;
                }

                // Candidate should know nobody
                if (mat[candidate][i] == 1) {
                    return -1;
                }

                // Everyone should know candidate
                if (mat[i][candidate] == 0) {
                    return -1;
                }
            }

            return candidate;
        }
    }
