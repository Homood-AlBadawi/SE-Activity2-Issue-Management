# SE-Activity2-Issue-Management

Issue (bug / defect / change) management in GitHub Issues — **Activity 2** for SE401 Software Quality Assurance and Testing, Prince Sultan University.

This repository holds a small Java class containing three deliberate faults. Each fault is tracked and managed through the full GitHub Issues workflow: a written description, a task list, labels, a milestone, an assignee and a project board.

## Contents

| Path | Description |
| --- | --- |
| `src/BuggyCodeExample.java` | The code under test. Contains three intentional faults, marked in comments. |

## Issue tracking

| Item | Where |
| --- | --- |
| Issue | [#1 — wrong max value, ArrayIndexOutOfBoundsException, integer division](../../issues/1) |
| Labels | `bug`, `defect` |
| Milestone | [v1.0 — Bug Fix Release](../../milestones) |
| Project board | SE Activity 2 — Bug Tracking Board |
| Assignee | @Homood-AlBadawi |

## Faults under test

| # | Method | Type | Problem | Fix |
| --- | --- | --- | --- | --- |
| 1 | `findMax()` | Bug | `max` is seeded with `0`, so an array of only negative numbers returns `0` — a value that is not in the array. The loop also starts at index 1, skipping the first element. | Seed with `numbers[0]` and start the loop at index 0 |
| 2 | `printArray()` | Bug | The loop condition `i <= arr.length` reads one position past the last valid index and throws `ArrayIndexOutOfBoundsException`. | Use `i < arr.length` |
| 3 | `calculateAverage()` | Defect | `sum / numbers.length` divides two `int` values, so the fractional part is discarded before the result is widened to `double`. | Cast before dividing: `(double) sum / numbers.length` |

Faults 1 and 2 are classified as **bugs** because they change the observable behaviour of the program. Fault 3 is classified as a **defect** because it returns a value of the right shape but the wrong precision.

## Running it

```bash
javac -d out src/BuggyCodeExample.java
java -cp out BuggyCodeExample
```

Current output — the program fails partway through, which is fault 2 doing its job:

```
Max: 4
1
-2
3
4
-5
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
```

Expected output once all three faults are fixed:

```
Max: 4
1
-2
3
4
-5
Average: 0.2
```

Note that `Max: 4` is printed even before the fix. Fault 1 does not reveal itself with this data, because the array happens to contain a positive maximum — it only appears with an all-negative array, which is why the issue records `findMax(new int[]{-3, -7, -1})` as its reproduction case.

---

**Course** — SE401 Software Quality Assurance and Testing

**Student** — Homood AlBadawi
